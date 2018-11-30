package Brücke;
import static org.lwjgl.opengl.GL11.*;

public class Facette {
	
	float [] mat_amb = {0.18f,0.18f,0.18f,0.18f};
	float [] mat_dif = {0.18f,0.18f,0.18f,0.18f};
	float [] mat_spec = {0.18f,0.18f,0.18f,0.18f};
	float shini = 5;
	
	public void drawFacetteRechteck(float n, float m, float b, float h) {
		glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
		glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
		glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
		
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				
				glBegin(GL_POLYGON);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
					glNormal3f(0.0f,0.0f,1.0f);
					glVertex3f(-b / 2 + b / m * i, -b / 2 + h / n * j, b / 2);
					glVertex3f(-b / 2 + b / m * (i + 1), -b / 2 + h / n * j, b / 2);
					glVertex3f(-b / 2 + b / m * (i + 1), -b / 2 + h / n * (j + 1), b / 2);
					glVertex3f(-b / 2 + b / m * i, -b / 2 + h / n * (j + 1), b / 2);
				glEnd();

			}

		}
	}
	

	
}
