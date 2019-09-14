import unittest

class DeveloperTestCase(unittest.TestCase):
    def test_step0(self):
        self.assertEqual(1,1)
    def test_step1(self):
        self.assertEqual(2,2)

if __name__ == '__main__':
    unittest.main()
