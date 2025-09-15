import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "https://results.govdoc.lk/results/jayoda-2160";
            Document doc = Jsoup.connect(url).get();

            System.out.println(" Lottery Results");

            Element title = doc.selectFirst("div.title-wrp h1");
            if (title != null) {
                System.out.println(title.text());
            }

            Elements results = doc.select("div.wrp.single-result.name div.result-block");

            if (!results.isEmpty()) {
                System.out.print("Winning Numbers: ");
                for (Element res : results) {
                    System.out.print(res.text() + " ");
                }
                System.out.println();
            } else {
                System.out.println("No results found – check selector.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
