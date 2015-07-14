import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

public class Basic {
  public static void main(String[] args) throws Exception {
    // Set the HTTP referrer to your website address.
    GoogleAPI.setHttpReferrer("http://http://stackoverflow.com/questions/9647293/google-translate-api-in-android-app");

    // Set the Google Translate API key
    // See: http://code.google.com/apis/language/translate/v2/getting_started.html
    GoogleAPI.setKey("Test");

    String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

    System.out.println(translatedText);
  }
}