import pyxel

SCREEN_SIZE = 32
IMAGE_BANK = 0
VELOCITY = 5
TRANSPARENT_COLOR = 14

# max width and height of screen is 256
# pyxel.init(256, 256, caption='load resource example', scale=1)
pyxel.init(SCREEN_SIZE*2, SCREEN_SIZE, caption='luckyduck', scale=10)

pyxel.load("assets/luckyduck.pyxres")

player_x = 0
player_y = 0

allmyducks = "c2d2e2f2 g2g2g2g2 a2a2a2a2 g2g2g2g2 a2a2a2a2 g2g2g2g2 f2f2f2f2 e2e2e2e2 d2d2d2d2 c2c2c2c2 r"
pyxel.sound(0).set(note=allmyducks, tone="t", volume="5", effect=("n"), speed=30)
pyxel.play(0, 0, loop=True)

def update():
    global player_x
    global player_y

    if pyxel.btnp(pyxel.KEY_Q):
        pyxel.quit()
    if pyxel.btn(pyxel.KEY_LEFT):
        if player_x > 0:
            player_x -= VELOCITY
    if pyxel.btn(pyxel.KEY_RIGHT):
        if player_x+VELOCITY+8 < SCREEN_SIZE*2:
            player_x += VELOCITY
    if pyxel.btn(pyxel.KEY_UP):
        if player_y > 0:
            player_y -= VELOCITY
    if pyxel.btn(pyxel.KEY_DOWN):
        if player_y+VELOCITY+8 < SCREEN_SIZE:
            player_y += VELOCITY

def draw():
    global player_x
    global player_y

    pyxel.cls(0)

    # blt(x, y, img, u, v, w, h, [colkey])

    # 256x256 sized 3 image banks

    # draw the ground
    pyxel.blt(0, 18, IMAGE_BANK, 8, 8, 8, 8, TRANSPARENT_COLOR)

    # draw the water
    for column in range(0, SCREEN_SIZE*2, 8):
        pyxel.blt(column, 0, IMAGE_BANK, 0, 8, 8, 8, TRANSPARENT_COLOR)
        pyxel.blt(column, 8, IMAGE_BANK, 0, 8, 8, 8, TRANSPARENT_COLOR)
        pyxel.blt(column, 16, IMAGE_BANK, 0, 8, 8, 8, TRANSPARENT_COLOR)
        pyxel.blt(column, 24, IMAGE_BANK, 0, 8, 8, 8, TRANSPARENT_COLOR)

    # draw the sun
    pyxel.blt(40, 10, IMAGE_BANK, 16, 0, 8, 8, TRANSPARENT_COLOR)

    # draw some trees
    pyxel.blt(20, 0, IMAGE_BANK, 16, 8, 8, 8, TRANSPARENT_COLOR)
    pyxel.blt(30, 0, IMAGE_BANK, 16, 8, 8, 8, TRANSPARENT_COLOR)
    
    pyxel.blt(player_x, player_y, IMAGE_BANK, 8, 0, 8, 8, TRANSPARENT_COLOR)

# call update and draw function
pyxel.run(update, draw)