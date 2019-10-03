class Node {
    constructor(data, next = null) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {

    constructor() {
        this.head = null;
    }

    size() {
        let counter = 0;
        let node = this.getFirst();
        while(node) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    clear() {
        this.head = null;
    }

    getAt(index) {
        if(!this.head) return null;

        let counter = 0;
        let node = this.getFirst();

        while(node) {
            if(counter == index) return node;
            counter++;
            node = node.next;
        }
        return null;
    }

    removeAt(index) {
        if(!this.head) return;
        if(index == 0) this.head = this.head.next;

        const previous = this.getAt(index-1);

        if(!previous || !previous.next) return;
        previous.next = previous.next.next;
    }

    insertAt(data, index) {
        if(!this.head) {
            this.head = new Node(data);
            return;
        }
        if(index === 0) {
            this.insertFirst(data);
            return;
        }

        const previous = this.getAt(index-1) || this.getLast();
        previous.next = new Node(data, previous.next);
    }

    getFirst() {
        return this.head;
    }

    insertFirst(data) {
        this.head = new Node(data, this.getFirst());
    }

    getLast() {
        let node = this.getFirst();
        while(node.next) {
            node = node.next;
        }
        return node;
    }

    insertLast(data) {
        let node = this.getFirst();
        if(!node) {
            this.head = new Node(data);
            return;
        }
        while(node.next) {
            node = node.next;
        }
        node.next = new Node(data);
    }

    removeFirst() {
        this.head = this.head.next;
    }

    removeLast() {
        let node = this.getFirst();

        if (!node) {
            return;
        }
    
        if (!node.next) {
            this.head = null;
            return;
        }

        while(node.next.next) {
            node = node.next;
        }
        node.next = null;
    }

    forEach(callback) {
        let node = this.getFirst();
        let counter = 0;
        while(node) {
            callback(node, counter);
            node = node.next;
            counter++;
        }
    }

    *[Symbol.iterator]() {
        let node = this.head;
        while(node) {
            yield node;
            node = node.next;
        }
    }
    
}

module.exports = { Node, LinkedList };
