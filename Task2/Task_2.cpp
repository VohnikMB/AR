#include<iostream>
using  namespace std;
class Vector
{
private:
    float* head;
    float length;
public:
    Vector() {
        length = 0;
        head = nullptr;
    };
    Vector(float len) {
        length = len;
        if (len > 0)
            head = new float[len];
        else
            head = nullptr;
    };
    Vector(float len, float values) {
        length = len;
        if (len > 0) {
            head = new float[len];
            for (int i = 0; i < len; i++)
                head[i] = values;
        }
        else
            head = nullptr;
    };
    Vector(const Vector& other) {
        length = other.length;
        if (other.length > 0) {
            head = new float[other.length];
            for (int i = 0; i < other.length; i++)
                head[i] = other.head[i];
        }
        else
            head = nullptr;
    };
    ~Vector() {
        if (length > 0) {
            delete[] head;
            head = nullptr;
            length = 0;
        }
    };
    Vector& operator = (const Vector& other) {
        if (this == &other)
            return *this;

        length = other.length;
        if (other.length > 0) {
            head = new float[other.length];
            for (int i = 0; i < other.length; i++)
                head[i] = other.head[i];
        }
        else
            head = nullptr;
        return *this;
    };
    Vector operator+(const Vector& other) {
        int maxLen = (length > other.length) ? length : other.length;
        Vector vector(maxLen);
        for (int i = 0; i < maxLen; i++) {
            if (i >= length) {
                vector.head[i] = other.head[i];
                continue;
            }
            if (i >= other.length) {
                vector.head[i] = head[i];
                continue;
            }
            vector.head[i] = head[i] + other.head[i];
        }
        return vector;
    };
    Vector operator-(const Vector& other) {
        int maxLen = (length > other.length) ? length : other.length;
        Vector vector(maxLen);
        for (int i = 0; i < maxLen; i++) {
            if (i >= length) {
                vector.head[i] = -other.head[i];
                continue;
            }
            if (i >= other.length) {
                vector.head[i] = head[i];
                continue;
            }
            vector.head[i] = head[i] - other.head[i];
        }
        return vector;
    };
    Vector operator*(const float& value) {
        Vector vector(length);
        for (int i = 0; i < length; i++)
            vector.head[i] = head[i] * value;
        return vector;
    };
    friend Vector operator*(const float& value, const Vector& vector) {
        Vector v_(vector.length);
        for (int i = 0; i < vector.length; i++)
            v_.head[i] = vector.head[i] * value;
        return v_;
    };
    Vector& operator+=(const Vector& other) {
        for (int i = 0; i < ((length < other.length) ? length : other.length); i++)
            head[i] += other.head[i];
        return *this;
    };
    Vector operator-=(const Vector& other) {
        for (int i = 0; i < ((length < other.length) ? length : other.length); i++)
            head[i] -= other.head[i];
        return *this;
    };
    Vector operator*=(const float& value) {
        for (int i = 0; i < length; i++)
            head[i] *= value;
        return *this;
    };
    float& operator[](const float& index) {
        if ((index < 0) || (index >= length))
            throw std::out_of_range("Wrong index");

        return head[(int)index];
    };
    friend std::ostream& operator<<(std::ostream& out, const Vector& vector) {
        if (vector.length <= 0)
            return out << "[]";
        out << '[' << vector.head[0];
        for (int i = 1; i < vector.length; i++)
            out << ", " << vector.head[i];
        return out << ']';
    };
    friend std::istream& operator>>(std::istream& in, Vector& vector) {
        for (int i = 0; i < vector.length; i++)
            in >> vector.head[i];
        return in;
    };
};

int main() {
    
    Vector a, b(3), c(5, 6.66), d(4);

    cout << "Enter 3 value Vector:\n";
    cin >> b;
    cout << "Enter 4 value Vector:\n";
    cin >> d;
    Vector e(d);
    cout << "Derivation of Vector type variables:\n";
    cout << "a= " << a << "\nb = " << b << "\nc = " << c << "\nd = " << d << "\ne = " << e << '\n';
    cout <<"b + d = " << b + d << '\n';
    cout <<"b - d = "<< b - d << '\n';
    cout << "b * 1.5 = " << b * 1.5 << '\n';
    cout << "3.01 * d = " << 3.01 * d << '\n';
    cout << "c += d = " << (c += d) << '\n';
    cout << "c -= b = " << (c -= b) << '\n';
    cout << "c *= 3 = " << (c *= 3) << '\n';
    cout << "e = " << e << '\n';
    cout << "b[2] = " << b[2] << '\n';
    cout << "c[3] = " << c[3] << '\n';
    return 0;
}
