package programmers;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        System.out.println(new 자물쇠와열쇠().solution(
                new int[][]{
                        {0, 0, 0}, {1, 0, 0}, {0, 1, 1}
                },
                new int[][]{
                        {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
                }));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int[][] multipledLock = new int[key.length * 2 + lock.length][key.length * 2 + lock.length];
        for (int y = 0; y < lock.length; y += 1) {
            for (int x = 0; x < lock.length; x += 1) {
                multipledLock[key.length + y][key.length + x] = lock[y][x];
            }
        }
        return isMatch(multipledLock, key, 0);
    }

    private boolean isMatch(int[][] lock, int[][] key, int number) {
        if (number == 5) {
            return false;
        }
        for (int y = 0; y < lock.length - key.length; y += 1) {
            for (int x = 0; x < lock.length - key.length; x += 1) {
                if (isUnlock(combineKeyAndLock(key, lock, y, x), key)) {
                    return true;
                }
            }
        }
        return isMatch(lock, rotateKeyClockWise(key), number + 1);
    }

    private boolean isUnlock(int[][] lock, int[][] key) {
        for (int y = 0; y < lock.length - key.length - key.length; y += 1) {
            for (int x = 0; x < lock.length - key.length - key.length; x += 1) {
                if (lock[key.length + y][key.length + x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] combineKeyAndLock(int[][] key, int[][] lock, int y, int x) {
        lock = copyLock(lock);
        for (int keyY = 0; keyY < key.length; keyY += 1) {
            for (int keyX = 0; keyX < key.length; keyX += 1) {
                if (key[keyY][keyX] == 1) {
                    if (lock[y + keyY][x + keyX] == 1) {
                        lock[y + keyY][x + keyX] = 0;
                    } else {
                        lock[y + keyY][x + keyX] = 1;
                    }
                }
            }
        }
        return lock;
    }

    private int[][] copyLock(int[][] lock) {
        int[][] newLock = new int[lock.length][lock.length];
        for (int y = 0; y < lock.length; y += 1) {
            for (int x = 0; x < lock.length; x += 1) {
                newLock[y][x] = lock[y][x];
            }
        }
        return newLock;
    }

    private int[][] rotateKeyClockWise(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for (int y = 0; y < key.length; y += 1) {
            for (int x = 0; x < key.length; x += 1) {
                newKey[x][y] = key[key.length - y - 1][x];
            }
        }
        return newKey;
    }
}