package ru.job4j.collections.iterator;

import java.util.Iterator;

/**
 * ru.job4j.collections.iterator.MatrixIterator
 *
 * @author romanvohmin
 * @version 1
 * @since 02.04.2020
 */
public class MatrixIterator<T> implements Iterator<T> {
    private int size;          //всего элементов в матрице
    private int position = 0;  //позиция текущего элемента для "выдачи"
    private int row = 0;       //строка текущего элемента
    private int col = 0;       //столбец текущего элемента
    private T[][] matrix;

    public MatrixIterator(T[][] matrix) {
        this.matrix = matrix;
        this.size = countElements(matrix);
    }

    /**
     * Метод подсчета всех элементов в двумерной матрице
     * @param matrix - двумерный массив
     * @return количество всех элементов
     */
    private int countElements(T[][] matrix) {  //считаем количество элементов в матрице
        int count = 0;
        for (T[] row : matrix) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        T element = matrix[row][col];  //запоминаем текущий элемент
        //переходим к следующему элементу
        position++;
        col++;
        while (row < matrix.length && col >= matrix[row].length) { //для того, чтоб пропустить возможные "пустые" строки
            col = 0;
            row++;
        }
        return element;
    }
}
