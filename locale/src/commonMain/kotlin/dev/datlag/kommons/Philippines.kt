package dev.datlag.kommons


data object Philippines : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PH")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PHL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(608)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(63)
    override val continent: Continent = Continent.Asia
}