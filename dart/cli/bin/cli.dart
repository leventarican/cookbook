import 'package:args/args.dart';

const help = 'help';

void main(List<String> arguments) {
  final parser = ArgParser()..addFlag(help, negatable: false, abbr: 'h');
  final argResults = parser.parse(arguments);

  if (argResults[help] as bool) {
    print('''# cli
    need help?
    ''');
  }
}
