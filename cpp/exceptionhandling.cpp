// ausnahmebehanldung.cpp
#include <iostream>
#include <string>
using namespace std;

// Exception Handling
// ein throw bewirkt, dass das Fehlerobjekt in die Aufrufumgebung geworden wird

// eine Fehlerklasse: Weder Datenelement noch Methoden müssen drin sein
// nur der Typ ist wichtig, damit es in der Aufrufumgebung bekannt ist.
class Fehler {
private:
	string message;
public:
	Fehler() {}
	Fehler(const string& s) : message(s) {}
	const string& getMessage() const {return message;}
};

double divide(int a, int b) {
	if(b<0)
		throw (string) "Fehler: Nenner ist negativ";
	if(b==0) {
		// Fehler err;
		// throw err;	// mit throw eine Exception auslösen
		// oder so 
		throw Fehler();
	}
	if(b==42) {
		throw 42;
	}
	return ((double)a/b);
}
// double dividieren(int a, int b) throw() {	// throw wird ignoriert
double dividieren(int a, int b) throw(Fehler) {
	if(b==0) {
		throw Fehler("\t\tausgerutscht!");
	}
	return ((double)a/b);
}

int main() {
	cout << "haengebruecke ueberqueren" << endl;
	try {
		// double res = divide(2,-1);
		double res = divide(2,0);
		// double res = divide(2,42);
		cout << res << endl;

		try {
			throw;
		} catch(double ed) {}
	} catch(string& es) {
		cout << "\tException: string abgefangen" << endl;
	} catch(Fehler& ef) {
		cout << "\tException: Fehler abgefangen" << endl;
	} catch(int& ei) {
		cout << "\tException: 42 abgefangen" << endl;
	}
	cout << "... ueberlebt :)" << endl;

	cout << "berg besteigen" << endl;
	try {
		dividieren(3,0);
	} catch(Fehler& ef) {
		cout << "\tException: Fehler abgefangen" << endl;
		cerr << ef.getMessage() << endl;
	}
	cout << "... ueberlebt :)" << endl;
}