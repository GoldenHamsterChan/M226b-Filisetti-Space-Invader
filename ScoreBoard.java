import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.Calendar;

/**
 * Die ScoreBoard Klasse wird benutzt um den Score anzuzeigen, man bekommt Score indem man 
 * Gegner t�tet
 * The ScoreBoard class will be used to display the score, you get score from killing enemies
 * 
 * @author Sandro Filisetti
 * @version V4.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    public ScoreBoard()
    {
        this(100);
    }

    /**
     * ScoreBoard mit Endresultat --- Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }

    /**
     * Macht das Scoreboard Bild/Screen --- Displays the Scoreboard image/Screen
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}