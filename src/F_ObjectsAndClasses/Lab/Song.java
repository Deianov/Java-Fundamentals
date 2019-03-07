package F_ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Song {
    private String typeList;
    private String name;
    private String time;

    private void setTypeList(String typeList) { this.typeList = typeList; }
    private String getTypeList() { return typeList; }

    private void setTime(String time) { this.time = time; }
    private String getTime() { return time; }

    private void setName(String name) { this.name = name; }
    private String getName() { return name; }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();

        for (int i = 0; i < numSongs ; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song songObject = new Song();

            songObject.setTypeList(type);
            songObject.setName(name);
            songObject.setTime(time);

            songsList.add(songObject);
        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songsList) {
                System.out.println(song.getName());
            }
        } else {
//            for (Song song : songsList) {
//                if (song.getTypeList().equals(typeList)) {
//                    System.out.println(song.getName());
//                }
//            }
            List<Song> filterSong = songsList.stream().filter(e -> e.getTypeList().equals(typeList)).collect(Collectors.toList());

            for (Song song : filterSong) {
                System.out.println(song.getName());
            }
        }
    }
}
