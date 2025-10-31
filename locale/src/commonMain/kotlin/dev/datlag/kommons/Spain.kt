package dev.datlag.kommons


data object Spain : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ES")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ESP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(724)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(34)
    override val continent: Continent = Continent.Europe
}