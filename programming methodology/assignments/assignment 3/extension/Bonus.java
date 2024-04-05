import java.awt.*;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Bonus extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	/* Animation delay */
	private static final int DELAY = 10;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		initialization();
		gamePlay();
	}

	/*
	 * Precondition: blank canvas.
	 * postcondition: bricks, paddle and ball are added on canvas at correct
	 * locations.
	 */
	private void initialization() {
		startLabel();
		bricks();
		paddle();
		ball();
	}

	// instruction message
	private void startLabel() {
		message("CLICK TO START");
		waitForClick(); // game starts only after a click
		removeAll();
	}

	/*
	 * draws 10x10 brick grid and adds
	 * spaces in between
	 */
	private void bricks() {
		for (int j = 0; j < NBRICK_ROWS; j++) { // for loop indicating the number of rows
			int column = j * (BRICK_HEIGHT + BRICK_SEP);// brick height and space in between of them is
			// multiplied by variable(j)

			for (int i = 0; i < NBRICKS_PER_ROW; i++) { // for loop indicates number of bricks in a row.
				// half of brick row and spaces in between
				int halfx = (BRICK_WIDTH * NBRICKS_PER_ROW) / 2 + (BRICK_SEP * (NBRICKS_PER_ROW - 1)) / 2;
				int x = WIDTH / 2 - halfx; // starting point

				// like we did with the number of rows, we calculate bricks' number in a row
				int row = i * (BRICK_WIDTH + BRICK_SEP);

				// after getting all the important information, we declare rectangle
				bricks = new GRect(BRICK_WIDTH, BRICK_HEIGHT);

				brickColors(j);// called method paints bricks accordingly to an instruction.
				bricks.setFilled(true);
				// x coordinate is a start point, we add variable row to it.
				// same on Y scale, offset is just a start point
				// so in case to make 10x10 wall we add rows vertically
				add(bricks, x + row, BRICK_Y_OFFSET + column);
				brickCount = NBRICKS_PER_ROW * NBRICK_ROWS;
			}
		}
	}

	// This is a previously declared method which colors every pair of rows in
	// different colors
	private void brickColors(int j) {
		switch (j) {
			case 0:
			case 1:
				bricks.setColor(Color.RED);
				break;
			case 2:
			case 3:
				bricks.setColor(Color.ORANGE);
				break;
			case 4:
			case 5:
				bricks.setColor(Color.YELLOW);
				break;
			case 6:
			case 7:
				bricks.setColor(Color.GREEN);
				break;
			// To simplify, every case other than what we mentioned will be CYAN, since
			// it's the last two remaining no need to write them down.
			default:
				bricks.setColor(Color.CYAN);
				break; // note - we need to type break after every case
		}
	}

	// method draws paddle
	private void paddle() {
		int x = WIDTH / 2 - PADDLE_WIDTH / 2; // getting x coordinate centered
		int y = getHeight() - (PADDLE_Y_OFFSET + PADDLE_HEIGHT); // using constant to calculate paddle's offset
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle, x, y);
	}

	// This method draws a ball
	private void ball() {
		int x = WIDTH / 2 - BALL_RADIUS;
		int y = getHeight() / 2 - BALL_RADIUS;
		//
		ball = new GOval(BALL_DIAM, BALL_DIAM);
		ball.setFilled(true);
		add(ball, x, y); // sets circle in the center
	}

	/*
	 * Precondition: game is initialized
	 * Postcondition: game works as intended, with its moving objects
	 */
	private void gamePlay() {
		addMouseListeners(); // we must add this to use mouse commands
		ballAnimation();
	}

	// animation for paddle
	public void mouseMoved(MouseEvent e) {
		/*
		 * in order to keep paddle's movement within borders, we ensure e.getX() is
		 * greater than
		 * half of paddle's width and less than application width minus half paddle
		 */
		if (e.getX() > PADDLE_WIDTH / 2 && e.getX() < getWidth() - PADDLE_WIDTH / 2) {
			// Y of the paddle is unchanged, e.getX() is linked to the middle of paddle
			paddle.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - (PADDLE_Y_OFFSET + PADDLE_HEIGHT));
		}
	}

	/*
	 * Precondition: ball is added on canvas
	 * Postcondition: ball moves within canvas borders, bounces off the walls and
	 * paddle,
	 * successfully removes bricks on its way.
	 */
	private void ballAnimation() {
		ballVelocity();
		while (brickCount != 0 || turnCount == 0) { // while loop which stops if player won/lost
			moveBall();
			bounceFromWalls();
			checkCollidingObject();
			won(); // message for win
			lost(); // message for loss
		}
	}

	private void ballVelocity() {
		// adds ball's horizontal and vertical speed
		vy = 3.0;
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean()) { // "vx" value is random
			vx = -vx;
		}
	}

	private void moveBall() {
		ball.move(vx, vy);
		pause(DELAY);
	}

	// Postcondition: ball can bounce from every wall, except the lower one
	private void bounceFromWalls() {
		if (ball.getY() < 0) {
			vy = -vy;
		}
		if (ball.getX() > getWidth() - BALL_DIAM || ball.getX() <= 0) {
			vx = -vx;
		}
	}

	private void checkCollidingObject() { // differentiates an object from the walls
		GObject collider = getCollidingObject();
		if (collider != null) { // checks if collider returns an object different from null
			if (collider == paddle && vy > 0) {
				paddleCollision();
				paddle.setColor(ball.getColor()); // gets color from the ball
			} else if (collider != paddle) {
				vy = -vy;
				remove(collider); // ball simultaneously bounces from a brick and removes it
				ball.setColor(collider.getColor()); // ball changes its color when touching a brick
				brickCount--; // brick counter
			}
		}
	}

	// makes paddle interaction with ball more advanced and fun
	private void paddleCollision() {
		double forth = PADDLE_WIDTH * 0.25; // 1/4 of paddle

		double firstForth = paddle.getX() + forth; // left corner of paddle
		double lastForth = paddle.getX() + (PADDLE_WIDTH - forth); // right corner of paddle

		if (ball.getX() < firstForth || ball.getX() > lastForth) {
			// if ball hits any of these corners, it will bounce the same route
			vx = -vx;
		}
		vy = -vy;
	}

	private void won() { // if every brick is removed you win!
		if (brickCount == 0) {
			removeAll();
			message("YOU WIN <333");
		}
	}

	/*
	 * Precondition: no consequences from touching the lower wall
	 * Postcondition: player is given with 3 lives, and every unsuccessful
	 * attempt will result in fewer lives.
	 */
	private void lost() {
		while (ball.getY() > getHeight() - BALL_DIAM) {
			remove(ball);
			turnCount--;
			returnBall();
			break;
		}
		if (turnCount == 0) {
			removeAll();
			message("GAME OVER :/"); // if player lose ball 3 times, "GAME OVER" message is put on canvas
		}

	}

	// after every unsuccessful attempt if lives remain,
	// adds ball back without resetting a progress
	private void returnBall() {
		if (turnCount > 0) {
			add(ball, WIDTH / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
			waitForClick();
		}
	}

	// checks every corner of the ball
	// returns if GObject
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} //
		else if (getElementAt(ball.getX() + BALL_DIAM, ball.getY()) != null) {
			return getElementAt(ball.getX() + BALL_DIAM, ball.getY());
		} //
		else if (getElementAt(ball.getX(), ball.getY() + BALL_DIAM) != null) {
			return getElementAt(ball.getX(), ball.getY() + BALL_DIAM);
		} //
		else if (getElementAt(ball.getX() + BALL_DIAM, ball.getY() + BALL_DIAM) != null) {
			return getElementAt(ball.getX() + BALL_DIAM, ball.getY() + BALL_DIAM);
		} //
		else {
			return null;
		}
	}

	// method which returns a message
	private void message(String string) {
		GLabel label = new GLabel(string);
		label.setFont("PLAIN-BOLD-30");
		add(label, WIDTH / 2 - label.getWidth() / 2, getHeight() / 2 + label.getAscent() / 2);
	}

	/* Private instance variables */
	private GRect bricks;
	private GRect paddle;
	private GOval ball;
	private int BALL_DIAM = BALL_RADIUS * 2; // calculating diameter of circle
	private double vx, vy;
	private int brickCount;
	private int turnCount = NTURNS;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}