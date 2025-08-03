
def sort_colors(arr):
    # Initialize three pointers
    low = 0           # For placing 0s
    mid = 0           # Current element under consideration
    high = len(arr) - 1  # For placing 2s

    # Traverse the array with mid pointer
    while mid <= high:
        if arr[mid] == 0:
            # Swap current element with the element at low
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
        elif arr[mid] == 1:
            # 1s are in the middle, just move forward
            mid += 1
        else:
            # Swap current element with the element at high
            arr[mid], arr[high] = arr[high], arr[mid]
            high -= 1  # Move high pointer left
            # Do not increment mid here because we need to check the swapped value

    return arr
