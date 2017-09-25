package lab1;


import java.util.*;

public class Main {
    public static final List<Integer> start = Arrays.asList(4, 8, 1, null, 3, 6, 2, 7, 5);
    public static final List<Integer> end = Arrays.asList(6, null, 8, 5, 2, 1, 4, 3, 7);

    public static void main(String[] args) {
        boolean flag = false;
        Vertex root = new Vertex(null, start);
        Vertex result = null;
        List<Vertex> vertexList = new ArrayList<>();
        List<Vertex> tmp = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        set.add(start);
        vertexList.add(root);
        while (!flag) {
            int size = vertexList.size();
            for (int i = 0; i < size; i++) {
                Vertex vertex = vertexList.remove(0);
                List<Vertex> children = expandChild(vertex, set);
                tmp.addAll(children);
            }
            vertexList = tmp;
            tmp = new ArrayList<>();
            for (Vertex v : vertexList) {
                if (equals(v.value, end)) {
                    result = v;
                    flag = !flag;
                    break;
                }
            }
        }
        printResult(result);
    }

    static void printResult(Vertex vertex) {
        while (vertex.parent != null) {
            System.out.println(toString(vertex));
            vertex = vertex.parent;
        }
        System.out.println(toString(vertex));
    }

    static String toString(Vertex vertex) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            Integer value = vertex.value.get(i);
            if (value == null) value = 0;
            builder.append(value + "\t");
            if ((i + 1) % 3 == 0 && i != 0 && i != 8) builder.append("\n");
        }
        builder.append("\n\n");
        return builder.toString();
    }

    static boolean equals(List<Integer> first, List<Integer> second) {
        for (int i = 0; i < 9; i++) {
            if (first.get(i) != second.get(i)) return false;
        }
        return true;
    }

    static List<Vertex> expandChild(Vertex parent, Set<List<Integer>> set) {
        List<Vertex> result = new LinkedList<>();
        List<Integer> matrix;
        Vertex v;
        switch (getZeroPosition(parent)) {
            case 0: {
                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 1: {
                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 2: {
                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 3: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 4: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 5: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 6: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 7: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
            case 8: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                if (set.add(v.value)) {
                    parent.children.add(v);
                    result.add(v);
                }
                break;
            }
        }
        return result;
    }
/*    static List<Vertex> expandChild(Vertex parent) {
        List<Vertex> result = new LinkedList<>();
        List<Integer> matrix;
        Vertex v;
        switch (getZeroPosition(parent)) {
            case 0: {
                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 1: {
                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 2: {
                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 3: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 4: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 5: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveBottom(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 6: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 7: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveRight(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
            case 8: {
                matrix = moveTop(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);

                matrix = moveLeft(parent);
                v = new Vertex(parent, matrix);
                parent.children.add(v);
                result.add(v);
                break;
            }
        }
        return result;
    }*/

    static List<Integer> copyList(List<Integer> target) {
        List<Integer> list = new ArrayList<>();
        list.addAll(target);
        return list;
    }

    static int getZeroPosition(Vertex parent) {
        int position = 0;
        for (Integer i : parent.value) {
            if (i == null) {
                break;
            }
            position++;
        }
        return position;
    }

    static List<Integer> moveTop(Vertex parent) {
        List<Integer> copy = copyList(parent.value);
        for (int i = 3; i < 9; i++) {
            Integer el = copy.get(i);
            if (el == null) {
                Collections.swap(copy, i, i - 3);
                break;
            }
        }
        return copy;
    }

    static List<Integer> moveBottom(Vertex parent) {
        List<Integer> copy = copyList(parent.value);
        for (int i = 0; i < 6; i++) {
            Integer el = copy.get(i);
            if (el == null) {
                Collections.swap(copy, i, i + 3);
                break;
            }
        }
        return copy;
    }

    static List<Integer> moveRight(Vertex parent) {
        List<Integer> copy = copyList(parent.value);
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < 6; ) {
            Integer el = copy.get(j);
            if (el == null) {
                Collections.swap(copy, j, j + 1);
                break;
            }
            if (flag) j += 2;
            else j += 1;
            flag = !flag;
        }
        return copy;
    }

    static List<Integer> moveLeft(Vertex parent) {
        List<Integer> copy = copyList(parent.value);
        int j = 1;
        boolean flag = false;
        for (int i = 0; i < 6; ) {
            Integer el = copy.get(j);
            if (el == null) {
                Collections.swap(copy, j, j - 1);
                break;
            }
            if (flag) j += 2;
            else j += 1;
            flag = !flag;
        }
        return copy;
    }
}
