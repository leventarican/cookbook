import pygame

class Settings:
    def __init__(self):
        self.screen_width = 1200
        self.screen_height = 800
        self.bg_color = (230, 230, 230)

        self.bullet_speed = 1.0
        self.bullet_width = 5
        self.bullet_height = 25
        self.bullet_color = (60, 230, 60)

        self.enemy_speed = 1.0
        self.enemy_drop_speed = 10
        self.enemy_direction = 1    # 1: right