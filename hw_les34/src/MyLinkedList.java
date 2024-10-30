public class MyLinkedList<T> { // Объявление класса MyLinkedList с параметризованным типом T
    private Node<T> head = null; // Приватное поле head, указывающее на начало списка
    private Node<T> tail = null; // Приватное поле tail, указывающее на конец списка
    private int size = 0; // Поле size для хранения количества элементов в списке

    public void add(T obj) { // Метод для добавления нового элемента в список
        if (head == null) { // Проверка, пуст ли список
            head = new Node<T>(obj, null, null); // Создание нового узла, если список пуст
            tail = head; // Установка нового узла как конечного элемента
        } else { // Если список не пуст
            Node<T> newNode = new Node<T>(obj, tail, null); // Создание нового узла в конце списка
            newNode.getPrev().setNext(newNode); // Обновление ссылки предыдущего узла
            tail = newNode; // Обновление tail для нового конечного узла
        }
        size++; // Увеличение размера списка на 1
    }

    public void print() { // Метод для вывода всех элементов списка
        Node<T> currentNode = head; // Начинаем с головного узла
        while (currentNode != null) { // Пока текущий узел не равен null
            System.out.println(currentNode.getObj()); // Вывод объекта узла
            currentNode = currentNode.getNext(); // Переход к следующему узлу
        }
    }

    public String toString() { // Метод для возвращения строкового представления списка
        StringBuilder sb = new StringBuilder(); // Создание StringBuilder для построения строки
        Node<T> currentNode = head; // Начинаем с головного узла
        while (currentNode != null) { // Пока текущий узел не равен null
            sb.append(currentNode.getObj()).append(System.lineSeparator()); // Добавляем объект узла и новую строку
            currentNode = currentNode.getNext(); // Переход к следующему узлу
        }
        return sb.toString(); // Возвращаем построенную строку
    }

    private Node<T> getNodeByIndex(int index) { // Метод для получения узла по индексу
        if (index < 0 || index >= size) { // Проверка на недопустимый индекс
            return null; // Возвращаем null, если индекс недопустимый
        }
        int currentIndex = 0; // Инициализация текущего индекса
        Node<T> currenNode = head; // Начинаем с головного узла
        while (currenNode != null && currentIndex != index) { // Пока не достигнем нужного индекса
            currenNode = currenNode.getNext(); // Переход к следующему узлу
            currentIndex++; // Увеличиваем текущий индекс на 1
        }
        return currenNode; // Возвращаем узел по нужному индексу
    }

    public T get(int index) { // Метод для получения объекта по индексу
        Node<T> nodeByIndex = getNodeByIndex(index); // Вызов метода для получения узла
        if (nodeByIndex != null) { // Проверка, найден ли узел
            return nodeByIndex.getObj(); // Возвращаем объект из узла
        }
        return null; // Возвращаем null, если индекс недопустимый
    }

    public int size() { // Метод для получения количества элементов в списке
        return size; // Возвращаем размер списка
    }

    public static <E> MyLinkedList<E> of(E... elements) { // Статический метод для создания списка с переданными элементами
        MyLinkedList<E> result = new MyLinkedList<>(); // Создание нового списка
        for (E element : elements) { // Перебор каждого элемента
            result.add(element); // Добавление элемента в список
        }
        return result; // Возвращаем созданный список
    }

    public void add1(int index, T element) {

        // Проверка, находится ли индекс вне допустимого диапазона
        if (index < 0 || index > size) {
            // Если индекс недопустимый, метод завершает выполнение
            return;
        }

        // Создание нового узла для вставки
        Node<T> newNode = new Node<>(element, null, null);

        // Если вставка в начало списка
        if (index == 0) {
            newNode.setNext(head); // Новый узел указывает на старый head
            if (head != null) {
                head.setPrev(newNode); // Обновляем ссылку предыдущего узла у head
            }
            head = newNode; // Новый узел становится новым head
            if (tail == null) { // Если это первый элемент, он также станет хвостом
                tail = newNode;
            }
        }
        // Если вставка в конец списка
        else if (index == size) {
            newNode.setPrev(tail); // Новый узел ссылается на старый tail как на предыдущий
            if (tail != null) {
                tail.setNext(newNode); // Устанавливаем новый узел как следующий у старого tail
            }
            tail = newNode; // Новый узел становится новым tail
        }
        // Вставка в середину списка
        else {
            Node<T> currentNode = head; // Начинаем с головы списка
            int currentIndex = 0; // Индекс текущего узла

            // Перемещаемся по списку, пока не достигнем нужного индекса
            while (currentIndex < index - 1) {
                currentNode = currentNode.getNext(); // Переход к следующему узлу
                currentIndex++;
            }

            // Устанавливаем связи для нового узла и узлов до и после него
            newNode.setNext(currentNode.getNext());
            newNode.setPrev(currentNode);
            currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
        }

        // Увеличиваем размер списка на 1
        size++;
    }



}
