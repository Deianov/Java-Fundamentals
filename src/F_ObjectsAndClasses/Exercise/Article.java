//02. Articles

package F_ObjectsAndClasses.Exercise;

import java.util.Scanner;

public class Article {

    private String title;
    private String content;
    private String author;

    private void rename(String title) { this.title = title; }
    private void changeAuthor(String author) { this.author = author; }
    private void edit(String content) { this.content = content; }

    private Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return this.title + " -" + this.content + ":" + this.author;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(",");

        Article article = new Article(line[0], line[1], line[2]);

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            line = scanner.nextLine().split(":");

            String value = line[1];

            switch (line[0]) {
                case "Edit": article.edit(value); break;
                case "ChangeAuthor": article.changeAuthor(value); break;
                case "Rename": article.rename(value); break;
            }
        }
        System.out.print(article.toString());
    }
}
