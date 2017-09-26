package stringgridbuilder;

/**
 * StringGridBuilder holds a list of 2d strings and returns 1 big 2d string
 */
public class StringGridBuilder {
    private GridItem grid[][];
    private int rows, cols;
    private final int GRID_ITEM_SIZE = 3;   // GridItems are 3x3
    private char[][] expandedGrid;
    private boolean hasGridChanged; // has grid changed
    
    /**
     * The rows and cols represent how many items can be added
     */
    public StringGridBuilder(int rows, int cols) {
        grid = new GridItem[rows][cols];
        this.rows = rows;
        this.cols = cols;
        expandedGrid = new char[rows*GRID_ITEM_SIZE][cols*GRID_ITEM_SIZE];
    }
    
    /**
     * Add's item to the grid of characters
     * @param item a 3x3 array of characters
     * @param x    the x position in the larger 2d array of characters
     * @param y    the y position in the larger 2d array of characters
     * @throws IndexOutOfBoundsException if x or y positions are out of bounds
     */
    public void addItem(char item[][], int x, int y) throws IndexOutOfBoundsException {
        GridItem temp = new GridItem(item, x, y);
        // check if temp can be placed in grid?
        if (x >= cols || y >= rows || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException(x + " " + y + " position is out of the grid");
        }
        grid[y][x] = temp;
        hasGridChanged = true;
    }
    
    /**
     * Expands a grid array into a full size char array
     */
    public void expandGrid() {
        if (!hasGridChanged) {
            return;
        }
        // iterate through a rows by cols board
        for (int y = 0; y < rows * GRID_ITEM_SIZE; y += GRID_ITEM_SIZE) {
            for (int x = 0; x < cols * GRID_ITEM_SIZE; x += GRID_ITEM_SIZE) {
                for (int i = 0; i < GRID_ITEM_SIZE; i++) {
                    for (int j = 0; j < GRID_ITEM_SIZE; j++) {
                        expandedGrid[y+i][x+j] = grid[y/GRID_ITEM_SIZE][x/GRID_ITEM_SIZE].item[i][j];
                    }
                }
            }
        }
        hasGridChanged = false; // prevent user expanding grid if it has already been expanded
    }
    
    /**
     * @return the final grid of characters
     */
    public char[][] getExpandedGrid() {
        return expandedGrid;
    }
    
    /**
     * @return whether or not the grid has been updated since it's last expansion
     */
    public boolean hasGridChanged() {
        return hasGridChanged;
    }
    
    /**
     * This method will return the expanded grid as a string with new lines rather than a 2d array of characters
     * @return a string of all the characters in 'reading' order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < rows * GRID_ITEM_SIZE; y++) {
            for (int x = 0; x < cols * GRID_ITEM_SIZE; x++) {
                sb.append(expandedGrid[y][x]);
            }
            sb.append('\n');
        }
        
        return sb.toString();
    }
    
    /**
     * GridItem
     */
    public class GridItem {
        int x, y, wd, ht;
        char item[][];
        
        GridItem(char item[][], int x, int y) {
            this.x = x;
            this.y = y;
            this.wd = item.length;
            this.ht = item[0].length;
            this.item = item;
        }
        
    }
}
