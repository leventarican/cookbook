var input = "code";

main() {
    String welcome = 
    '''
this is a kata: mexican wave.
example: Code cOde coDe codE
    ''';
    print(welcome);

    var chars = input.split("");
    var f = (i) => chars[i].toUpperCase();
    for (var i = 0; i < chars.length; i++) {
        var x = f(i);
        chars[i] = x;
        print(chars.join());
        chars[i] = x.toLowerCase();
    }
}
