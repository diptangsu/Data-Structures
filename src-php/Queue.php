<?php

namespace srcPhp;

use srcPhp\LinkedList;

class Queue {

    private $n;
    private $queue;

    public function __construct(int $n = 20) {
	    $this->n = $n;
	    $this->queue = new LinkedList();
    }

    public function dequeue(): string {
	    if ($this->isEmpty()) {
	        throw new UnderflowException('Queue is empty');
        } else {
	        $lastItem = $this->peek();
	        $this->queue->removeFirst();
	        return $lastItem;
	    }
    }

    public function enqueue(string $newItem) {
	    if ($this->queue->getSize() < $this->n) {
	        $this->queue->insertLast($newItem);
	    } else {
	        throw new OverflowException('Queue is full');
	    }
    }

    public function peek(): string {
	    return $this->queue->getAt(1)->data;
    }

    public function isEmpty(): bool {
	    return $this->queue->getSize() == 0;
    }

}
