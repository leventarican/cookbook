import pyautogui
import random

wh = pyautogui.size() # screen resolution

print(f'{wh}')
print(f'{wh[0]}')
print(f'{wh.width}')

# moving the mouse and finally click
for i in range(2, 10, 3):
    x_y = random.randrange(2)
    if x_y == 0:
        pyautogui.moveTo(i*100, 100, duration=0.25)
    else:
        pyautogui.moveTo(100, i*100, duration=0.25)
pyautogui.click()
