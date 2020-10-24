namespace srcPhp;

use srcPhp\Node;

class LinkedList implements \Iterator {

    private $_firstNode = NULL;
    private $_lastNode = NULL;
    private $_totalNode = 0;
    private $_currentNode = NULL;
    private $_currentPosition = 0;

    public function insertLast(string $data = NULL) {
        $newNode = new Node($data);
        if ($this->_firstNode === NULL) {
            $this->_firstNode = &$newNode;
            $this->_lastNode = &$newNode;
        } else {
            $currentNode = $this->_lastNode;
            $currentNode->next = $newNode;
            $newNode->prev = $currentNode;
            $this->_lastNode = &$newNode;
        }
        $this->_totalNode++;
        return TRUE;
    }

    public function insertFirst(string $data = NULL) {
        $newNode = new Node($data);
        if ($this->_firstNode === NULL) {
            $this->_firstNode = &$newNode;
            $this->_lastNode = &$newNode;
        } else {
            $currentFirstNode = $this->_firstNode;
            $this->_firstNode = &$newNode;
            $newNode->next = $currentFirstNode;
            $this->_lastNode = &$currentFirstNode;
        }
        $this->_totalNode++;
        return TRUE;
    }

    public function insertAt(string $data = NULL, string $index = NULL) {
        $newNode = new Node($data);

        if ($this->_firstNode) {
            $previous = NULL;
            $currentNode = $this->_firstNode;
            while ($currentNode !== NULL) {
                if ($currentNode->data === $index) {
                    $newNode->next = $currentNode;
                    if ($previous === NULL) {
                        $this->_firstNode = &$newNode;
                    } else {
                        $previous->next = $newNode;
                    }
                    $this->_totalNode++;
                    break;
                }
                $previous = $currentNode;
                $currentNode = $currentNode->next;

            }
        }
    }

    public function removeFirst() {
        if ($this->_firstNode !== NULL) {
            if ($this->_firstNode->next !== NULL) {
                $this->_firstNode = $this->_firstNode->next;
            } else {
                $this->_firstNode = NULL;
                $this->_lastNode = NULL;
            }
            $this->_totalNode--;
            return TRUE;
        }
        return FALSE;
    }

    public function removeLast() {
        if ($this->_firstNode !== NULL) {
            $currentNode = $this->_firstNode;
            if ($currentNode->next === NULL) {
                $this->_firstNode = NULL;
            } else {
                $previousNode = NULL;

                while ($currentNode->next !== NULL) {
                    $previousNode = $currentNode;
                    $currentNode = $currentNode->next;
                }

                $previousNode->next = NULL;
                $this->_lastNode = &$previousNode;
                $this->_totalNode--;
                return TRUE;
            }
        }
        return FALSE;
    }

    public function removeAt(string $index = NULL) {
        if ($this->_firstNode) {
            $previous = NULL;
            $currentNode = $this->_firstNode;
            while ($currentNode !== NULL) {
                if ($currentNode->data === $index) {
                    if ($currentNode->next === NULL) {
                        $previous->next = NULL;
                    } else {
                        $previous->next = $currentNode->next;
                    }

                    if($currentNode === $this->_lastNode) {
                        $this->_lastNode = &$previous;
                    }

                    $this->_totalNode--;
                    break;
                }
                $previous = $currentNode;
                $currentNode = $currentNode->next;
            }
        }
    }

    public function getFirst() {
        if ($this->_firstNode !== NULL)
            return $this->_firstNode->data;
    }

    public function getLast() {
        if ($this->_lastNode !== NULL)
            return $this->_lastNode->data;
    }

    public function getAt(int $n = 0) {
        $count = 1;
        if ($this->_firstNode !== NULL && $n <= $this->_totalNode) {
            $currentNode = $this->_firstNode;
            while ($currentNode !== NULL) {
                if ($count === $n) {
                    return $currentNode;
                }
                $count++;
                $currentNode = $currentNode->next;
            }
        }
    }

    public function getSize() {
        return $this->_totalNode;
    }

    public function current() {
        return $this->_currentNode->data;
    }

    public function next() {
        $this->_currentPosition++;
        $this->_currentNode = $this->_currentNode->next;
    }

    public function key() {
        return $this->_currentPosition;
    }

    public function rewind() {
        $this->_currentPosition = 0;
        $this->_currentNode = $this->_firstNode;
    }

    public function valid() {
        return $this->_currentNode !== NULL;
    }

}
