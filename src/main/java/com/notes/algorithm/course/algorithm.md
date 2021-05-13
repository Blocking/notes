# [数据结构与算法之美](https://time.geekbang.org/column/intro/126)

## 二分查找
**二分查找针对的是一个有序集合。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半
，直到找到要查找的元素，或者区间被缩小为0。**
### 算法复杂度：`O(logn)`
### 程序实体

    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
### 重点关注
#### 1. 循环退出条件
注意是 low<=high，而不是 low
#### 2. mid的取值
`mid = (low + high) / 2` 这种写法在`low` 和`high`非常大的情况下 可能会造成溢出
使用`low+(high-low)/2`可以改进这种问题
#### 3.  low 和 high 的更新
`low=mid+1，high=mid-1`。注意这里的 `+1` 和 `-1`，如果直接写成 `low=mid` 或者 
`high=mid`，就可能会发生死循环。比如，当 `high=3，low=3 `时，如果 `a[3]`不等于 `value`，就会导致一直循环不退出
