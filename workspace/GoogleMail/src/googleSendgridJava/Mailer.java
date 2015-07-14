package googleSendgridJava;
import googleSendgridJava.Sendgrid;

public class Mailer 
{
	public static void main(String[] args)
	{
		// set credentials
		Sendgrid mail = new Sendgrid("diptikaushik09@gmail.com","9934446935");

		// set email data
		mail.setTo("akshay0007k@gmail.com").setFrom("diptikaushik09@gmail.com").setSubject("Test mail").setText("Hello World!").setHtml("<strong>Hello World!</strong>");

		// send your message
		mail.send();
	}
}
