package dev.datlag.kommons

internal class PriorityQueue<T>(
    private val comparator: Comparator<in T>?
) {

    constructor(comparator: (T, T) -> Int) : this(Comparator(comparator))

    private val heap: MutableList<T> = mutableListOf()

    val size: Int
        get() = heap.size

    fun isEmpty(): Boolean = heap.isEmpty()

    fun offer(element: T) {
        heap.add(element)
        shiftUp(heap.size - 1)
    }

    fun poll(): T? {
        if (isEmpty()) {
            return null
        }
        if (size == 1) {
            return heap.removeAt(0)
        }

        val head = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        shiftDown(0)

        return head
    }

    fun peek(): T? = heap.getOrNull(0)

    fun clear() {
        heap.clear()
    }

    private fun shiftUp(index: Int) {
        var i = index
        while (i > 0) {
            val parentIndex = if (i % 2 == 0) i / 2 - 1 else i / 2

            if (compare(heap[parentIndex], heap[i]) > 0) {
                swap(i, parentIndex)
                i = parentIndex
            } else {
                break
            }
        }
    }

    private fun shiftDown(index: Int) {
        var i = index

        while (i * 2 + 1 < size) {
            val leftChildIndex = i * 2 + 1
            val rightChildIndex = leftChildIndex + 1

            val childIndex = if (rightChildIndex >= size) {
                leftChildIndex
            } else {
                val leftChildValue = heap[leftChildIndex]
                val rightChildValue = heap[rightChildIndex]

                if (compare(leftChildValue, rightChildValue) < 0) leftChildIndex else rightChildIndex
            }

            if (compare(heap[childIndex], heap[i]) < 0) {
                swap(i, childIndex)
                i = childIndex
            } else {
                break
            }
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    @Suppress("UNCHECKED_CAST")
    private fun compare(a: T, b: T): Int {
        return comparator?.compare(a, b) ?: (a as Comparable<T>).compareTo(b)
    }
}