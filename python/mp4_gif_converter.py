import os
import sys
# read frames from mp4 with imageio
# you need imageio, ffmpeg, ... modules
import imageio

def read_filename():
    try:
        mp4 = sys.argv[1]
        return mp4
    except IndexError as e:
        print('usage: python3 mp4_gif_converter.py <file.mp4>')
        sys.exit(1)

def read_mp4_and_write_gif(mp4):
    reader = imageio.get_reader(mp4, fps=1)
    frames = []
    for i,im in enumerate(reader):
        frames.append(im)
    gif = mp4[0:len(mp4)-4] + '.gif'
    imageio.mimsave(gif, frames, format='gif', fps=2)

# test for imageio; read default imageio png
im = imageio.imread('imageio:chelsea.png')
print(im.shape)

mp4 = read_filename()
read_mp4_and_write_gif(mp4)
