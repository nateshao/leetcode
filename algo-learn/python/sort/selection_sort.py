import random
from typing import List

# ιζ©ζεΊ


def selectionSort(data: List[int]):
    length = len(data)
    if length <= 1:
        return

    for i in range(length - 1):
        least = i
        for j in range(i + 1, length):
            if data[j] < data[least]:
                least = j
        data[i], data[least] = data[least], data[i]
