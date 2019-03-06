//04. Articles 2.0

package F_ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Article2 {

    private String title;
    private String content;
    private String author;

    private void rename(String title) { this.title = title; }
    private void changeAuthor(String author) { this.author = author; }
    private void edit(String content) { this.content = content; }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    private Article2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private void print() {
        System.out.printf("%s -%s:%s%n", this.getTitle(), this.getContent(), this.getAuthor());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Article2> article2List = new ArrayList<>();

        while (count-- > 0) {
            String[] line = scanner.nextLine().split(",");

            Article2 article2 = new Article2(line[0], line[1], line[2]);
            article2List.add(article2);
        }

        String sort = scanner.nextLine();

        switch (sort) {
            case "title": article2List.sort(Comparator.comparing(o -> o.getTitle()));break;
            case "content": article2List.sort(Comparator.comparing(o -> o.getContent()));break;
            case "author": article2List.sort(Comparator.comparing(o -> o.getAuthor()));break;
        }

        for (Article2 art : article2List) {
            art.print();
        }
    }
}
