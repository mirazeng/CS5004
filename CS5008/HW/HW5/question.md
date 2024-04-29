# HW5 Written Questions

## 4.1 Making doubly linked lists even faster?

In the single linked list implementation, we have only one choice of traveling, starting from the head of the list. But a doubly linked list allows us to travel from both the head and/or the tail.

We can exploit this property (but not locality) by first calculating whether the target element to `set` or `get` is closer to the head or the tail. Then, we use head or tail respectively and travel from there, reducing the required traveling steps.

We can implement this optimization by adding to the `get` and `set` functions to first do a little calculation using passed-in `index` which is the target element's index.
- If `index - list.length/2 > 0`, then target element is closer to tail than head, and we start going backwards using `prev` from tail. 
- If `index - list.length/2 < 0`, then target element is closer to head than tail, and we start going forward using `next` from list's head.

## 4.2 Lists By Dynamic Memory, For Dynamic Memory?

*Q1:* 
The heap manages memory dynamically by maintainig a list of free, contiguous memories for allocation to programs when needed. When we call `malloc`, the heap—through some mechanism of deciding—will allocate a list of contiguous free memories that matches the required size. However, the heap does not give back this list itself but rather, a pointer to the first (head) free memories in this list.

A linked list not only represents this logic better but also allows dynamic usage of this allocated memory. Because we can add/remove from head/tail of linked list, if the list of allocated memories are indeed in linked list form, we can then add/remove memories addresses without needing to do operations on the linked list as a whole. The same kind of operation on fixed-length list might involve shifting the whole thing, or padding, or even copying to a new one with desired length, so in comparison, linked lists are more flexible.

*Q2:*
When the heap returns the pointer to the list of contiguous free memories, it actually stores some metadata on that list of memories as well, including the size of this list of memories. Thus, we do not need to specify the size of memory addresses to free because the heap is already maintaining that information for us when we first use `malloc`.

Plus, (in my opinion), if the underlying structure is like a linked list, the heap might be able to just continuously de-allocate the given addresses from start, until the tail. This is kind of like how we free a linked list ourselves in using linked list structs. But using metadata works just fine already.
