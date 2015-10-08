package practice.CCAssignment.ch5;

/**
 *
 * @author Akash Gandotra
 */
public class Solution08 {

    public static void main(String[] args) {
        int width = 8 * 1;
        int height = 1;
        MonochromeScreen obj = new MonochromeScreen(width, height);
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    obj.drawLine(c1, c2, r);
                    obj.printScreen();
                    System.out.println("\n\n");
                }
            }
        }
    }
}

class MonochromeScreen {
    
    private byte[] screen;
    private int width;
    private int height;
    
    public MonochromeScreen(int width, int height){
        this.width = width;
        this.height = height;
        screen = new byte[width * height / 8];
    }

    public int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }

    public void drawLine(int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    public void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public void printScreen() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c += 8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println("");
        }
        resetScreen();
    }

    public void resetScreen() {
        screen = new byte[width * height / 8];        
    }
}
