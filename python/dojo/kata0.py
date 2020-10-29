
# example input => output
# #######################
# XO("ooxx") => true
# XO("xooxx") => false
# XO("ooxXm") => true
# XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
# XO("zzoo") => false

def xo(s):
    o = s.lower().replace("o", "")
    x = s.lower().replace("x", "")
    return len(o) == len(x)

# ##############################################################################

import unittest

# unittest will test all the methods whose name starts with test
class SampleTest(unittest.TestCase):
    def test_0(self):
        self.assertTrue(xo("ooxx"))
    def test_1(self):
        self.assertTrue(xo("ooxXm"))
    def test_2(self):
        self.assertFalse(xo("zzoo"))

unittest.main()
# ...
# ----------------------------------------------------------------------
# Ran 3 tests in 0.000s

# OK
