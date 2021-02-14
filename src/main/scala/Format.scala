object Format:
  type ToFormat[X <: Tuple] = X match
    case EmptyTuple => String
    case '%' *: 's' *: ts => (String => ToFormat[ts])
    case '%' *: 'd' *: ts => (Int => ToFormat[ts])
    case Char *: ts => ToFormat[ts]