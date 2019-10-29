import math

import pyxel

class App:
    def __init__(self):
        pyxel.init(200, 150, caption="based on Pixel Sound API")

        pyxel.image(0).set(
            0,
            0,
            [
                "11100000",
                "01100100",
                "01100100",
                "01100100",
                "01100100",
                "01100000",
                "01111110",
                "01111111",
            ],
        )

        # 4 channels with 64 definable sounds

        # note: List of note(0-127) (33 = 'A2' = 440Hz)
        # tone: List of tone(0:Triangle / 1:Square / 2:Pulse / 3:Noise)
        # volume: List of volume(0-7)
        # effect: List of effects(0:None / 1:Slide / 2:Vibrato / 3:FadeOut)
        # speed: The length of one note(120 = 1 second per tone)

        # {'c', 0}, {'d', 2}, {'e', 4}, {'f', 5}, {'g', 7}, {'a', 9}, {'b', 11}

        # #####################################################################
        # https://jythonmusic.me/ch-2-elements-of-music-and-code/

        # In Python, pitches are represented by a letter (C, D, E, F, G, A, or B) 
        # followed by the octave (or register) of the pitch (as seen below).

        # These symbols (e.g., C4) stand for integers and range from 0 to 127.
        # For example, C4 (middle C on a piano) is 60. 
        # This follows the MIDI standard, which represents pitches 
        # from 0 (lowest pitch) to 127 (highest pitch)

        # #####################################################################

        # pyxel.sound(0).set(
        #     "e2e2c2g1 g1g1c2e2 d2d2d2g2 g2g2rr" "c2c2a1e1 e1e1a1c2 b1b1b1e2 e2e2rr",
        #     "s",
        #     "5",
        #     "vffn fnff vffs vfnn",
        #     20,
        # )

        # notes = "c3e3g3c4c4"
        notes = "c4d4e4f4 g2g2 a4a4a4a4 g1" "a4a4a4a4 g1 f4f4f4f4" "e4e4 d4d4d4d4 c4"
        pyxel.sound(0).set(
            # note=notes, tone="s", volume="7", effect=("n" * 4 + "f"), speed=20
            note=notes, tone="s", volume="7", effect=("nnnn sss fff"), speed=40
        )

        # melody1 = (
        #     "c3 c3 c3 d3 e3 r e3 r"
        #     + ("r" * 8)
        #     + "e3 e3 e3 f3 d3 r c3 r"
        #     + ("r" * 8)
        #     + "c3 c3 c3 d3 e3 r e3 r"
        #     + ("r" * 8)
        #     + "b2 b2 b2 f3 d3 r c3 r"
        #     + ("r" * 8)
        # )

        # melody2 = (
        #     "rrrr e3e3e3e3 d3d3c3c3 b2b2c3c3"
        #     + "a2a2a2a2 c3c3c3c3 d3d3d3d3 e3e3e3e3"
        #     + "rrrr e3e3e3e3 d3d3c3c3 b2b2c3c3"
        #     + "a2a2a2a2 g2g2g2g2 c3c3c3c3 g2g2a2a2"
        #     + "rrrr e3e3e3e3 d3d3c3c3 b2b2c3c3"
        #     + "a2a2a2a2 c3c3c3c3 d3d3d3d3 e3e3e3e3"
        #     + "f3f3f3a3 a3a3a3a3 g3g3g3b3 b3b3b3b3"
        #     + "b3b3b3b4 rrrr e3d3c3g3 a2g2e2d2"
        # )

        # # Music
        # pyxel.sound(0).set(
        #     note=melody1 * 2 + melody2 * 2,
        #     tone="s",
        #     volume=("3"),
        #     effect=("nnnsffff"),
        #     speed=10,
        # )

        self.play_music(True)

        pyxel.run(self.update, self.draw)

    def play_music(self, ch0):
        if ch0:
            pyxel.play(0, 0, loop=True)
        else:
            pyxel.stop(0)

    def update(self):
        if pyxel.btnp(pyxel.KEY_Q):
            pyxel.quit()

        if pyxel.btnp(pyxel.KEY_1):
            self.play_music(True)

        if pyxel.btnp(pyxel.KEY_5):
            self.play_music(False)

    def draw(self):
        pyxel.cls(1)

        pyxel.text(6, 6, "sound(snd).set(note,tone,volume,effect,speed)", 7)
        pyxel.rect(12, 14, 177, 35, 2)
        pyxel.text(16, 17, "note  :[CDEFGAB] + [ #-] + [0-4] or [R]", 9)
        pyxel.text(16, 25, "tone  :[T]riangle [S]quare [P]ulse [N]oise", 9)
        pyxel.text(16, 33, "volume:[0-7]", 9)
        pyxel.text(16, 41, "effect:[N]one [S]lide [V]ibrato [F]adeOut", 9)

        pyxel.text(6, 53, "music(msc).set(ch0,ch1,ch2,ch3)", 7)
        pyxel.text(6, 62, "play(ch,snd,loop=False)", 7)
        pyxel.text(6, 71, "playm(msc,loop=False)", 7)
        pyxel.text(6, 80, "stop([ch])", 7)

        pyxel.rectb(6, 97, 188, 47, 14)
        pyxel.rect(6, 91, 29, 7, 14)
        pyxel.text(7, 92, "CONTROL", 1)

        pyxel.text(12, 102, "1: Play all channels", 14)
        pyxel.text(12, 110, "2: Play channel #0 (Melody)", 14)
        pyxel.text(12, 134, "5: Stop playing", 14)

        pyxel.text(137, 107, "play_pos(ch)", 15)

        for i in range(3):
            x = 140 + i * 16
            y = 123 + math.sin(pyxel.frame_count * 0.1 + i * 2.1) * 5
            col = 15 if pyxel.play_pos(i) >= 0 else 13

            pyxel.pal(1, col)
            pyxel.blt(x, y, 0, 0, 0, 8, 8, 0)

        pyxel.pal()


App()
