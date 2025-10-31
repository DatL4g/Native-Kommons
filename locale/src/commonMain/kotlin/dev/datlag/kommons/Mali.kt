package dev.datlag.kommons


data object Mali : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ML")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MLI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(466)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(223)
    override val continent: Continent = Continent.Africa
}