package programmers;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();

        for (int index = 0; index < genres.length; index++) {
            Song song = new Song(index, plays[index]);

            if(map.containsKey(genres[index])){
                map.get(genres[index]).addSong(song);
            }else{
                Genre genre = new Genre();
                genre.addSong(song);
                map.put(genres[index], genre);
            }
        }


        List<Genre> genreList = new ArrayList<>();

        for(String name : map.keySet()){
            genreList.add(map.get(name));
        }

        genreList.sort((o1, o2) -> o1.getPlayCount() >= o2.getPlayCount() ? -1 : 1);

        List<Integer> answer = new ArrayList<>();

        for(int index = 0; index < genreList.size(); index++){
            Genre genre = genreList.get(index);

            Queue<Song> songs = genre.getPlayList();
            answer.add(songs.poll().getIndex());

            if(!songs.isEmpty()){
                answer.add(songs.poll().getIndex());
            }
        }

        int[] result = new int[answer.size()];

        for(int index =0; index<result.length; index++){
            result[index] = answer.get(index);
        }

        return result;
    }

    class Genre{
        private int playCount;
        private final Queue<Song> playList;

        public Genre() {
            this.playList = new PriorityQueue<>();
        }

        public void addSong(Song song){
            this.playCount += song.getPlayCount();
            this.playList.add(song);
        }

        public int getPlayCount() {
            return playCount;
        }

        public Queue<Song> getPlayList() {
            return playList;
        }
    }

    class Song implements Comparable<Song>{
        private final int index;
        private final int playCount;

        public Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }

        public int getIndex() {
            return index;
        }

        public int getPlayCount() {
            return playCount;
        }

        @Override
        public int compareTo(Song o) {
            if(this.playCount > o.getPlayCount()){
                return -1;
            }else if(this.playCount < o.getPlayCount()){
                return 1;
            }else{
                if(this.getIndex() < o.getIndex()){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
}
