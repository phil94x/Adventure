package Wasser;
import static org.lwjgl.opengl.GL11.*;
public class Wasser {
	
	Welle1 welle1 = new Welle1();
	Welle2 welle2 = new Welle2();
	Umgebung umgebung = new Umgebung();
	
	public void drawWasser() {
		//Test-Umgebung
		
//		glPushMatrix();
//			glTranslatef(0,12,0);
//			umgebung.drawUmgebung();
//		glPopMatrix();

		//Wasser
		glPushMatrix();
			glTranslatef(0,0,-42);
			welle1.drawWelle();
		glPopMatrix();
		glPushMatrix();
			glRotatef(90,0,1,0);
			glTranslatef(0,0,-42);
			welle2.drawWelle();
		glPopMatrix();
	
	}

}
