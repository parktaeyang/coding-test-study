package z_grammer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * ListNode에 대한 설명과 예시
 * 
 * 주의: ListNode는 Java의 기본 클래스가 아님.
 * - Java 버전과 무관: 표준 라이브러리의 일부가 아님
 * - 코딩 테스트(LeetCode 등)에서 링크드 리스트를 표현하기 위해 사용하는 커스텀 클래스
 * - 실무에서는 java.util.LinkedList를 사용
 */
public class ListNodeTest {

    /**
     * ListNode 클래스 정의
     * 코딩 테스트에서 일반적으로 사용되는 형태
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * 디버깅용: 리스트를 문자열로 변환
         * 예: 1 -> 2 -> 3 -> null
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    /**
     * 테스트 1: ListNode 기본 구조 이해
     * - val: 노드에 저장된 값
     * - next: 다음 노드를 가리키는 참조
     */
    @Test
    void testBasicStructure() {
        // 단일 노드 생성
        ListNode node1 = new ListNode(1);
        assertEquals(1, node1.val);
        assertNull(node1.next); // 다음 노드가 없으므로 null

        // 두 노드 연결
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        assertEquals(2, node1.next.val);
        assertNull(node1.next.next);

        // 생성자로 직접 연결
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, node3);
        assertEquals(4, node4.val);
        assertEquals(3, node4.next.val);
    }

    /**
     * 테스트 2: 코딩 테스트에서 자주 사용되는 리스트 생성 방법
     * 배열이나 값들을 받아서 ListNode 리스트로 변환
     */
    @Test
    void testCreatingListFromArray() {
        // 방법 1: 배열로부터 리스트 생성 (코딩 테스트에서 가장 흔함)
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createListFromArray(values);

        // 리스트 순회하며 확인
        ListNode current = head;
        for (int i = 0; i < values.length; i++) {
            assertNotNull(current);
            assertEquals(values[i], current.val);
            current = current.next;
        }
        assertNull(current); // 마지막 노드의 next는 null

        System.out.println("생성된 리스트: " + head); // 1 -> 2 -> 3 -> 4 -> 5
    }

    /**
     * 테스트 3: 리스트 순회 (코딩 테스트에서 필수)
     * - 현재 노드를 다음으로 이동
     * - while 루프 사용
     */
    @Test
    void testTraversingList() {
        ListNode head = createListFromArray(new int[]{10, 20, 30});

        // 순회하며 값 수집
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next; // 다음 노드로 이동
        }

        assertEquals(3, values.size());
        assertEquals(10, values.get(0));
        assertEquals(20, values.get(1));
        assertEquals(30, values.get(2));
    }

    /**
     * 테스트 4: 리스트 길이 구하기
     */
    @Test
    void testGetListLength() {
        ListNode head1 = createListFromArray(new int[]{1, 2, 3});
        assertEquals(3, getLength(head1));

        ListNode head2 = createListFromArray(new int[]{1});
        assertEquals(1, getLength(head2));

        assertNull(null); // null 리스트의 길이는 0
    }

    /**
     * 테스트 5: 리스트에 노드 추가하기
     */
    @Test
    void testAddNode() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node2;
        node2.next = node3;

        assertEquals(3, getLength(head));
        assertEquals("1 -> 2 -> 3", head.toString());
    }

    /**
     * 테스트 6: 리스트 뒤에 노드 추가 (append)
     */
    @Test
    void testAppendNode() {
        ListNode head = new ListNode(1);
        append(head, 2);
        append(head, 3);
        append(head, 4);

        assertEquals(4, getLength(head));
        assertEquals("1 -> 2 -> 3 -> 4", head.toString());
    }

    /**
     * 테스트 7: 두 리스트 연결하기
     */
    @Test
    void testConcatenateLists() {
        ListNode list1 = createListFromArray(new int[]{1, 2, 3});
        ListNode list2 = createListFromArray(new int[]{4, 5, 6});

        // list1의 끝을 찾아서 list2 연결
        ListNode current = list1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list2;

        assertEquals(6, getLength(list1));
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6", list1.toString());
    }

    /**
     * 테스트 8: 실무에서는 java.util.LinkedList 사용
     * 코딩 테스트의 ListNode와 비교
     */
    @Test
    void testRealWorldLinkedList() {
        // 실무에서 사용하는 Java 표준 라이브러리
        LinkedList<Integer> realLinkedList = new LinkedList<>();
        realLinkedList.add(1);
        realLinkedList.add(2);
        realLinkedList.add(3);

        // 코딩 테스트의 ListNode (직접 구현)
        ListNode testList = createListFromArray(new int[]{1, 2, 3});

        // 같은 데이터 구조이지만 사용 방법이 다름
        assertEquals(3, realLinkedList.size());
        assertEquals(3, getLength(testList));

        // 실무: 편리한 메서드 제공
        assertEquals(Integer.valueOf(1), realLinkedList.get(0));
        assertEquals(Integer.valueOf(2), realLinkedList.get(1));

        // 코딩 테스트: 직접 순회해야 함
        ListNode current = testList;
        assertEquals(1, current.val);
        current = current.next;
        assertEquals(2, current.val);
    }

    /**
     * 테스트 9: 리스트 값 수정
     */
    @Test
    void testModifyValues() {
        ListNode head = createListFromArray(new int[]{1, 2, 3});

        // 모든 값에 10 더하기
        ListNode current = head;
        while (current != null) {
            current.val += 10;
            current = current.next;
        }

        assertEquals("11 -> 12 -> 13", head.toString());
    }

    /**
     * 테스트 10: 특정 값 찾기
     */
    @Test
    void testFindValue() {
        ListNode head = createListFromArray(new int[]{10, 20, 30, 40});

        // 값 30 찾기
        ListNode found = findNode(head, 30);
        assertNotNull(found);
        assertEquals(30, found.val);
        assertEquals(40, found.next.val);

        // 없는 값 찾기
        ListNode notFound = findNode(head, 99);
        assertNull(notFound);
    }

    /**
     * 테스트 11: 역순으로 리스트 생성 (코딩 테스트에서 유용)
     */
    @Test
    void testReverseOrder() {
        // 역순으로 연결: 3 -> 2 -> 1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);

        assertEquals("3 -> 2 -> 1", node3.toString());
    }

    // ========== 헬퍼 메서드들 ==========

    /**
     * 배열로부터 ListNode 리스트 생성 (코딩 테스트에서 매우 자주 사용)
     */
    static ListNode createListFromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * 리스트 길이 구하기
     */
    static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 리스트 끝에 노드 추가
     */
    static void append(ListNode head, int val) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    /**
     * 특정 값을 가진 노드 찾기
     */
    static ListNode findNode(ListNode head, int target) {
        ListNode current = head;
        while (current != null) {
            if (current.val == target) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
