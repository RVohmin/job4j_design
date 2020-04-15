package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.iterator.MatrixIterator
 *
 * @author romanvohmin
 * @version 2
 * @since 02.04.2020
 */
public class MatrixIterator<T> implements Iterator<T> {
    private T[][] matrix;
    private int row = 0;
    private int col = 0;

    /**
     * redefined constructor
     * @param matrix - two-dimensional array
     */
    public MatrixIterator(T[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Method checked for exist an elements in matrix,
     * if element equal last element in row (and it is not last row in matrix),
     * then row++ and element stayed at first position of row
     * @return is exist elements in matrix
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (matrix.length > 0) {
            result = true;
            while (col == matrix[row].length) {
                if (row != matrix.length - 1) {
                    row++;
                    col = 0;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     *
     * @return next element of matrix (of row, then move to the next row at first position until end matrix)
     * moving pointer to next row makes hasNext()
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return matrix[row][col++];
    }
}
