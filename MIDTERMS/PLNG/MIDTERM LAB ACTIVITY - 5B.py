"""Part B - Campus music playlist (doubly linked list, linear).

Run normally for the interactive menu, or `python <file> demo` to run the
required demonstration and test cases automatically.
"""
import sys


class SongNode:
    def __init__(self, title):
        self.title = title
        self.prev = None
        self.next = None


class Playlist:
    def __init__(self):
        self.head = self.tail = self.current = None

    def add_song(self, title):
        node = SongNode(title)
        if self.head is None:
            self.head = self.tail = self.current = node
        else:
            node.prev = self.tail
            self.tail.next = node
            self.tail = node
        print(f"Added: {title}")

    def next_song(self):
        if self.current is None:
            print("Playlist is empty.")
        elif self.current.next is None:
            print("Already at the last song.")
        else:
            self.current = self.current.next
            print(f"After next: {self.current.title}")

    def previous_song(self):
        if self.current is None:
            print("Playlist is empty.")
        elif self.current.prev is None:
            print("Already at the first song.")
        else:
            self.current = self.current.prev
            print(f"After previous: {self.current.title}")

    def show_current(self):
        if self.current is None:
            print("Playlist is empty.")
        else:
            print(f"Current: {self.current.title}")

    def display_forward(self):
        if self.head is None:
            print("Forward: (empty)")
            return
        titles = []
        cur = self.head
        while cur is not None:
            titles.append(cur.title)
            cur = cur.next
        print("Forward: " + " <-> ".join(titles))

    def display_backward(self):
        if self.tail is None:
            print("Backward: (empty)")
            return
        titles = []
        cur = self.tail
        while cur is not None:
            titles.append(cur.title)
            cur = cur.prev
        print("Backward: " + " <-> ".join(titles))

    def remove_song(self, title):
        node = self.head
        while node is not None and node.title != title:
            node = node.next
        if node is None:
            print(f"Song '{title}' not found.")
            return False

        # choose the new current song before unlinking
        if node is self.current:
            self.current = node.next if node.next is not None else node.prev

        # reconnect neighbours
        if node.prev is not None:
            node.prev.next = node.next
        else:
            self.head = node.next
        if node.next is not None:
            node.next.prev = node.prev
        else:
            self.tail = node.prev

        node.prev = node.next = None
        if self.head is None:
            self.head = self.tail = self.current = None
        print(f"Removed: {title}")
        return True

    def check_references(self):
        """Verify the reference rules from the activity sheet."""
        if self.head is None:
            return self.tail is None and self.current is None
        if self.head.prev is not None or self.tail.next is not None:
            return False
        cur = self.head
        while cur.next is not None:
            if cur.next.prev is not cur:
                return False
            cur = cur.next
        return cur is self.tail


def menu():
    pl = Playlist()
    while True:
        print("\n1 Add song | 2 Next | 3 Previous | 4 Show current | "
              "5 Display forward | 6 Display backward | 7 Remove song | 0 Exit")
        choice = input("Choose: ").strip()
        if choice == "1":
            title = input("Song title: ").strip()
            if title:
                pl.add_song(title)
            else:
                print("Title cannot be empty.")
        elif choice == "2":
            pl.next_song()
        elif choice == "3":
            pl.previous_song()
        elif choice == "4":
            pl.show_current()
        elif choice == "5":
            pl.display_forward()
        elif choice == "6":
            pl.display_backward()
        elif choice == "7":
            pl.remove_song(input("Title to remove: ").strip())
        elif choice == "0":
            print("Goodbye!")
            break
        else:
            print("Invalid option. Please enter 0-7.")


def demo():
    print("=== Required demonstration ===")
    pl = Playlist()
    for s in ("Sunrise", "Ocean", "Starlight"):
        pl.add_song(s)
    pl.show_current()
    pl.next_song()
    pl.previous_song()
    pl.remove_song("Ocean")
    pl.display_forward()
    pl.display_backward()
    print("References OK:", pl.check_references())

    print("\n=== Test: empty playlist ===")
    e = Playlist()
    e.next_song(); e.previous_song(); e.show_current()
    e.display_forward(); e.display_backward(); e.remove_song("X")

    print("\n=== Test: boundaries ===")
    b = Playlist()
    for s in ("A", "B", "C"):
        b.add_song(s)
    b.previous_song(); b.show_current() # at first
    b.next_song(); b.next_song(); b.next_song(); b.show_current() # at last

    print("\n=== Test: removals ===")
    r = Playlist()
    for s in ("A", "B", "C", "D", "E"):
        r.add_song(s)
    r.remove_song("A"); r.display_forward(); r.display_backward() # head (current)
    r.show_current()
    r.remove_song("C"); r.display_forward(); r.display_backward() # middle
    r.remove_song("E"); r.display_forward(); r.display_backward() # tail
    r.next_song(); r.show_current() # now at D (last)
    r.remove_song("D"); r.show_current() # current is last -> previous
    print("References OK:", r.check_references())
    r.remove_song("B") # only song
    print("head/tail/current all None:",
          r.head is None and r.tail is None and r.current is None)

    print("\n=== Test: duplicates ===")
    d = Playlist()
    for s in ("Echo", "Wave", "Echo"):
        d.add_song(s)
    d.remove_song("Echo")
    d.display_forward(); d.display_backward()


if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == "demo":
        demo()
    else:
        menu()
