import threading
import logging

def run_in_thread(name):
    for i in range(0,3):
        logging.info(f'thread-{name} - i: {i}')

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO, datefmt="%H:%M:%S")
    logging.info("threading: hands-on")

    for i in range(3):
        t = threading.Thread(target=run_in_thread(i), args=(1,))
        t.start()
