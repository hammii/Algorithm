import java.util.*;

class Song implements Comparable<Song> {
    String genre;
    int plays;
    int index;

    Song(String genre, int plays, int index) {
        this.genre = genre;
        this.plays = plays;
        this.index = index;
    }

    @Override
    public int compareTo(Song o) {
        if (plays < o.plays) {
            return 1;
        } else if (plays == o.plays) {
            if (index > o.index) {
                return 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        List<Song> songList = new ArrayList<>();
        HashMap<String, Integer> playsMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            songList.add(new Song(genres[i], plays[i], i));
            playsMap.put(genres[i], playsMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 내림차순 정렬
        List<String> list = new ArrayList<>();
        list.addAll(playsMap.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer v1 = playsMap.get(o1);
                Integer v2 = playsMap.get(o2);

                return v2 - v1;
            }
        });

        // 노래 내림차순 정렬 & 정답 배열에 추가
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Song> gSongList = new ArrayList<>();
            for (Song song : songList) {
                if (list.get(i).equals(song.genre)) {
                    gSongList.add(song);
                }
            }
            gSongList.sort(new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.plays - o1.plays;
                }
            });

            answerList.add(gSongList.get(0).index);
            if (gSongList.size() >= 2) {
                answerList.add(gSongList.get(1).index);
            }
        }

        // 어레이리스트 배열로 변경
        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}