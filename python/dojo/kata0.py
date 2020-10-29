
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

# xo('xo')
# xo('xo0')
