import java.util.List;
public class Hill {
	/* variable init */
int hillNumber;
String name;
String county;
double height;
double latitude;
double longitude;

/* Custom constructor */
	public Hill(int hillNumber, String name, String county, double height, double latitude, double longitude){
	
		this.name = name;
		this.hillNumber = hillNumber;
		this.county = county;
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/* toString method to print out the Hill data */
	public String toString(){
		
		return hillNumber + ", " + name + ", " + height + ", " + latitude + ", " + longitude + "\n";
	}
	
	
}
