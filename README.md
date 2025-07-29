# DSA_Practice

This repository contains my **from-scratch implementations** of core Data Structures and Sorting Algorithms in Java. It's a personal deep dive into how these tools actually work — built line by line, with no shortcuts and no libraries doing the work for me.

---

## 📦 Data Structures Implemented

- **Arrays**
- **HashMap**
- **HashSet**
- **Stack**
- **Queue**
- **Linked List**
- **Tree / Binary Search Tree (BST)**
- **Trie**

All structures are hand-coded using raw Java syntax — no importing of Java Collections. This approach forced me to understand memory access, pointer logic (via references), and the structural integrity of each implementation.

---

## ⚙️ Algorithms Implemented

- **Merge Sort**
- **Quick Sort**

Each sorting algorithm was implemented recursively, emphasizing divide-and-conquer logic and in-place swaps. I focused on time complexity, call stack depth, and edge-case handling (e.g., already sorted or reversed arrays).

---

## 🧠 What I Learned

### 🔸 Arrays
- Arrays are simple, but off-by-one indexing errors are very real. Bounds checking is essential.
- Common misconception: assuming resizing is automatic. It’s not — arrays are fixed in size.

### 🔸 HashMap / HashSet
- Learned how hashing works, how collisions happen, and how to resolve them (chaining vs open addressing).
- Misconception: people forget hashcodes can collide. Equality must be handled explicitly with `.equals()` and `.hashCode()` overrides.

### 🔸 Stack & Queue
- Implemented both using arrays and linked lists.
- Key insight: people confuse "LIFO vs FIFO" under pressure. I drilled through examples to keep it second nature.

### 🔸 Linked List
- Understood how reference manipulation works when inserting/removing nodes.
- Misconception: thinking `head` and `current` are interchangeable — they're not. Losing the head pointer means losing the entire list.

### 🔸 BST (Binary Search Tree)
- Learned how insertion, deletion, and search operations balance trade-offs.
- Misconception: people often forget the recursive nature of deletion, especially with two children (inorder successor logic).

### 🔸 Trie
- Built a Trie to reinforce prefix trees and how character-by-character maps work.
- Misconception: many think Tries are just for autocomplete — but they’re powerful for pattern matching and dictionary checks.

---

## 🔍 Algorithms — What I Focused On

### Merge Sort
- Practiced splitting arrays down to base cases and merging in sorted order.
- Key detail: merging requires **extra space**, and improper indexing kills performance.

### Quick Sort
- Reinforced partitioning logic and how to pivot correctly.
- Misconception: many use the first element as pivot and suffer on already-sorted inputs. I tested randomized pivoting for more stability.

---

## 📁 Folder Structure

- `DataStructures/` – all data structure classes
- `Algorithms/` – all sorting algorithm classes

---

## 🎯 Why I Did This

- Build intuition beyond API usage
- Prep for coding interviews and whiteboard challenges
- Develop muscle memory for core logic patterns

---

## 🚀 Next Steps

- Add JUnit test cases for each module
- Visualize structure behavior (especially BST and Trie)
- Implement BFS/DFS, Heap Sort, and Graph algorithms

---

If you're a beginner looking to learn DSA from scratch, feel free to fork this repo, study the code, and build your own implementations on top.

Pull requests or suggestions are welcome.
