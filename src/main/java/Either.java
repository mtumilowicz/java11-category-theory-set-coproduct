import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by mtumilowicz on 2018-12-26.
 */
public interface Either<L, R> {

    static <L, R> Either<L, R> right(R right) {
        return new Right<>(right);
    }

    static <L, R> Either<L, R> left(L left) {
        return new Left<>(left);
    }

    L getLeft();

    boolean isLeft();

    boolean isRight();

    R getRight();

    final class Left<L, R> implements Either<L, R> {

        private final L value;

        private Left(L value) {
            this.value = value;
        }

        @Override
        public R getRight() {
            throw new NoSuchElementException();
        }

        @Override
        public L getLeft() {
            return value;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Left && Objects.equals(value, ((Left) obj).value));
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Left" + "(" + value + ")";
        }
    }

    final class Right<L, R> implements Either<L, R> {

        private final R value;

        private Right(R value) {
            this.value = value;
        }

        @Override
        public R getRight() {
            return value;
        }

        @Override
        public L getLeft() {
            throw new NoSuchElementException();
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Right && Objects.equals(value, ((Right) obj).value));
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Right" + "(" + value + ")";
        }
    }
}

