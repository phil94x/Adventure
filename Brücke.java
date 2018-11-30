package Brücke;
import static org.lwjgl.opengl.GL11.*;

public class Brücke {
	
		float anzSteineSeitenteil=25;
		float verschiebungX =1.2f;
		float verschiebungY =0.8f;
		float verschiebungZ =1.2f;
		
		SteinBrücke stein1 = new SteinBrücke();
		Brückenbogen brückenbogen = new Brückenbogen();
	
	public void drawBrücke() {
	
		glPushMatrix();
			drawSeitenteil();
			glTranslatef(-verschiebungX*(anzSteineSeitenteil-1),0,5);		
			drawSeitenteil();
		glPopMatrix();
		glPushMatrix();
			glTranslatef(15.6f,0,0);
			brückenbogen.drawBrückenbogen();
		glPopMatrix();
	}
	public void drawSeitenteil() {
		stein1.drawStein();
		for(int i=0; i <anzSteineSeitenteil;i++) {
			if(i<10) {
				glTranslatef(verschiebungX,verschiebungY,0);
				stein1.drawStein();	
			}
			if(i >=10 && i < 15) {
				glTranslatef(1,0,0);
				stein1.drawStein();
			}
			if(i>=15 && i<25) {
				glTranslatef(verschiebungX,-verschiebungY,0);
				stein1.drawStein();
			}
		}
	}
	
	
}
