from random import randint

import pyxel


class App:
    def __init__(self):
        pyxel.init(160, 120, caption="Pyxel Jump")

        pyxel.load("assets/luckyduck0.pyxres")

        self.score = 0
        self.player_x = 16
        self.player_y = 16*6
        self.player_vy = 0
        self.player_jump = False
        self.player_is_alive = True
        self.player_gravity = 0

        self.fruit = [(i * 60, randint(0, 104), randint(0, 2), True) for i in range(4)]

        # pyxel.playm(0, loop=True)

        allmyducks = "c2d2e2f2 g2g2g2g2 a2a2a2a2 g2g2g2g2 a2a2a2a2 g2g2g2g2 f2f2f2f2 e2e2e2e2 d2d2d2d2 c2c2c2c2 r"
        pyxel.sound(0).set(note=allmyducks, tone="t", volume="5", effect=("n"), speed=20)
        pyxel.play(0, 0, loop=True)

        # print(pyxel.height)   = 120
        # print(pyxel.width)    = 160

        pyxel.run(self.update, self.draw)

    def update(self):
        if pyxel.btnp(pyxel.KEY_Q):
            pyxel.quit()

        self.update_player()

        for i, v in enumerate(self.fruit):
            self.fruit[i] = self.update_fruit(*v)

    def update_player(self):
        if pyxel.btn(pyxel.KEY_SPACE):
            self.player_jump = True

        print(self.player_gravity)

        if self.player_jump:
            self.player_gravity += min(self.player_gravity+1, 16)

        if self.player_y <= 40:
            self.player_gravity -= max(0, self.player_gravity+1)
            self.player_jump = False

        self.player_y -= self.player_gravity

        if self.player_y > 96:
            self.player_y = 96
            self.player_gravity = 0

    def update_fruit(self, x, y, kind, is_active):
        if is_active and abs(x - self.player_x) < 12 and abs(y - self.player_y) < 12:
            is_active = False
            self.score += (kind + 1) * 100
            pyxel.play(3, 4)

        x -= 2

        if x < -40:
            x += 240
            y = randint(0, 104)
            kind = randint(0, 2)
            is_active = True

        return (x, y, kind, is_active)

    def draw(self):
        pyxel.cls(12)

        # draw sky
        pyxel.blt(0, 88, 0, 0, 88, 160, 32)

        # draw mountain
        pyxel.blt(0, 88, 0, 0, 64, 160, 24, 12)

        # draw forest
        offset = pyxel.frame_count % 160
        for i in range(2):
            pyxel.blt(i * 160 - offset, 104, 0, 0, 48, 160, 16, 12)

        # draw fruits
        for x, y, kind, is_active in self.fruit:
            if is_active:
                pyxel.blt(x, y, 0, 32 + kind * 16, 0, 16, 16, 12)

        # draw player
        pyxel.blt(
            self.player_x,
            self.player_y,
            0,
            16 if self.player_gravity > 0 else 0,
            0,
            16,
            16,
            12,
        )

        # draw score
        s = "SCORE {:>4}".format(self.score)
        pyxel.text(5, 4, s, 1)
        pyxel.text(4, 4, s, 7)


App()
