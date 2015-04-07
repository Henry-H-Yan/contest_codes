public class CDPlayer{
	public int isRandom(String[] songlist, int n){
		int len=songlist.length; String song;
		if(len!=1){
			song=songlist[0];
			for(int i=1;i<len;i++){
				String temp=songlist[i];
				song=song+temp;

			}
		}else {song=songlist[0];}
		for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[n];
            int j;
            for (j = 0; j < i; j++) {
                    if (used[song.charAt(j) - 'A'])
                            break;
                    used[song.charAt(j) - 'A'] = true;
            }
            // System.out.println(i + " " + j);
            if (j < i)
                    continue;
            for (; j < song.length(); j++) {
                    if (j % n == i)
                            used = new boolean[n];
                    if (used[song.charAt(j) - 'A'])
                            break;
                    used[song.charAt(j) - 'A'] = true;
            }
            if (j < song.length())
                    continue;
            return i;
    }
    return -1;
		
		
		
	}
}